package com.abadock.projectecafeteriacantanhede

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.abadock.projectecafeteriacantanhede.data.UserProvider
import com.abadock.projectecafeteriacantanhede.databinding.FragmentLoginBinding
import com.abadock.projectecafeteriacantanhede.databinding.FragmentRegisterBinding

class LoginActivity : AppCompatActivity() {
    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val bindingLogin: FragmentLoginBinding = DataBindingUtil.setContentView(this, R.layout.fragment_login)
        val bindingRegister : FragmentRegisterBinding = DataBindingUtil.setContentView(this, R.layout.fragment_register)

        bindingLogin.buttonLogin.setOnClickListener {
            if (login(bindingLogin.nameLabelLogin.text.toString(), bindingLogin.passLabelLogin.text.toString())){
                finish()
            } else {
                Toast.makeText(this, "El usuario no existe", Toast.LENGTH_SHORT).show()
            }

        }

        bindingRegister.buttonRegister.setOnClickListener {
            if (register(bindingRegister.nameLabelRegister.text.toString(), bindingRegister.passLabelRegister.text.toString())){
                finish()
            } else {
                Toast.makeText(this, "El usuario no existe", Toast.LENGTH_SHORT).show()
            }

        }

    }

    private fun register(username: String, contrasena: String): Boolean {
        return UserProvider.addUser(username, contrasena)
    }

    private fun login(username: String, contrasena: String): Boolean {
        return UserProvider.loadUsuarios(username, contrasena)
    }
}