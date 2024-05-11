package com.example.mycarstore.data

import android.content.Context
import android.widget.Toast
import com.example.mycarstore.models.Product
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers


fun savedData(
    applicantData: Applicant,
    context: Context,
) = CoroutineScope (Dispatchers. 10). Launch {
    val fireStoreRef = Firebase.firestore
        .collection("applicants")
        .document(applicantData.applicant Id . toString ())
    try {

        fireStoreRef.set(applicantData)
            .addOnSuccessListener {
                Toast.makeText(context, "APPLICATION SUCCESSFULLY SENT", Toast.LENGTH_SHORT).show()
            }
    } catch (e: Exception) {
        Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
    }

}


fun fetchData(
    collectionPath: String,
    context: Context,
    onDataReceived: (List<Product>?,String?)  -> Unit) {
    val firestore = Firebase.firestore
    firestore.collection(collectionPath)
        .gat()
        .addOnSuccessListener{ result ->
            val dataList = mutableListOf<Product>()
            for (document in result) {
                val data = document.toObject(Product::class.java)
                dataList.add(data)
            }
            onDataReceived(dataList,null)

        }
        .addOnFailureListener{ e ->
            onDataReceived(null, e.message)
        }
}

