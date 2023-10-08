package com.yablunin.shop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val signUsernameInput: EditText = findViewById(R.id.sign_username_input);
        val signEmailInput: EditText = findViewById(R.id.sign_email_input);
        val signPasswordInput: EditText = findViewById(R.id.sign_password_input);

        val signButton: Button = findViewById(R.id.sign_button);

        val loginLink: TextView = findViewById(R.id.sign_login_link);

        loginLink.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java);
            startActivity(intent);
        }

        signButton.setOnClickListener{
            if (!signUsernameInput.text.toString().isEmpty()
                && !signEmailInput.text.toString().isEmpty()
                && !signPasswordInput.text.toString().isEmpty()){
                val username: String = signUsernameInput.text.toString().trim();
                val email: String = signEmailInput.text.toString().trim();
                val password: String = signPasswordInput.text.toString().trim();

                val user = User(username, email, password);

                val dbHandler = DatabaseHandler(this, null);
                dbHandler.addUser(user);

                signUsernameInput.text.clear();
                signEmailInput.text.clear();
                signPasswordInput.text.clear();
            }
        }
    }
}