package com.yablunin.shop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val usernameInput: EditText = findViewById(R.id.login_username_input);
        val passwordInput: EditText = findViewById(R.id.login_password_input);

        val loginButton: Button = findViewById(R.id.login_button);

        val signLink: TextView = findViewById(R.id.login_sign_link);

        signLink.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java);
            startActivity(intent);
        }

        loginButton.setOnClickListener {
            if (!usernameInput.text.toString().isEmpty() && !passwordInput.text.toString().isEmpty()){
                val username: String = usernameInput.text.toString();
                val password: String = passwordInput.text.toString();

                val db = DatabaseHandler(this, null);
                val isAuth = db.getUser(username, password);
                if (isAuth){
                    val intent = Intent(this, ItemsActivity::class.java);
                    startActivity(intent);
                }
                else{
                    // Error message
                    Toast.makeText(this, "Ошибка входа!", Toast.LENGTH_LONG).show();
                }
            }
        }
    }
}