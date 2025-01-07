package com.abadock.projectecafeteriacantanhede.data

class UserProvider {
    companion object{
        private var verUsuarios= mutableListOf(
            UserModel("Jaume", "4321"),
            UserModel("Admin", "4321"),
            UserModel("Joel", "4321"),
            UserModel("Marcos", "4321"),
            UserModel("Guilherme", "4321"),
        )

        fun loadUsuarios(usuario: String, contrasena: String): Boolean{
            var verificacion = (verUsuarios.find { it.nombre == usuario && it.contrasena == contrasena})
            if(verificacion == null){
                return false
            }
            return true
        }

        fun addUser(usuario: String, contrasena: String): Boolean{
            var verificacion = (verUsuarios.find { it.nombre == usuario && it.contrasena == contrasena})
            if(verificacion == null){
                verUsuarios.add(UserModel(usuario, contrasena))
                return true
            }
            return false
        }
    }
}