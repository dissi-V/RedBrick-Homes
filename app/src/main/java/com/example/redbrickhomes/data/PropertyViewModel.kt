package com.example.redbrickhomes.data

import android.app.ProgressDialog
import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation.NavHostController
import com.example.redbrickhomes.navigation.LOGIN_URL
import com.example.redbrickhomes.models.Property
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.storage.FirebaseStorage

class PropertyViewModel(var navController:NavHostController, var context: Context) {
    var authViewModel:AuthViewModel
    var progress:ProgressDialog
    init {
        authViewModel = AuthViewModel(navController, context)
        if (!authViewModel.isLoggedIn()){
            navController.navigate(LOGIN_URL)
        }
        progress = ProgressDialog(context)
        progress.setTitle("Loading")
        progress.setMessage("Please wait...")
    }

    fun uploadProperty(name:String, location:String, price:String, filePath:Uri){
        val propertyId = System.currentTimeMillis().toString()
        val storageRef = FirebaseStorage.getInstance().getReference()
                                .child("Propertys/$propertyId")
        progress.show()
        storageRef.putFile(filePath).addOnCompleteListener{
            progress.dismiss()
            if (it.isSuccessful){
                // Save data to db
                storageRef.downloadUrl.addOnSuccessListener {
                    var imageUrl = it.toString()
                    var property = Property(name,location,price,imageUrl,propertyId)
                    var databaseRef = FirebaseDatabase.getInstance().getReference()
                        .child("Propertys/$propertyId")
                    databaseRef.setValue(property).addOnCompleteListener {
                        if (it.isSuccessful){
                            Toast.makeText(this.context, "Success", Toast.LENGTH_SHORT).show()
                        }else{
                            Toast.makeText(this.context, "Error", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }else{
                Toast.makeText(this.context, "Upload error", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun allProperty(
        property:MutableState<Property>,
        propertys:SnapshotStateList<Property>):SnapshotStateList<Property>{
        progress.show()
        var ref = FirebaseDatabase.getInstance().getReference()
                    .child("Propertys")
        ref.addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                propertys.clear()
                for (snap in snapshot.children){
                    var retrievedProperty = snap.getValue(Property::class.java)
                    property.value = retrievedProperty!!
                    propertys.add(retrievedProperty)
                }
                progress.dismiss()
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, "DB locked", Toast.LENGTH_SHORT).show()
            }
        })
        return propertys
    }

    fun deleteProperty(propertyId:String){
        var ref = FirebaseDatabase.getInstance().getReference()
                            .child("Property/$propertyId")
        ref.removeValue()
        Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
    }
}