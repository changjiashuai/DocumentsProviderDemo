package io.github.changjiashuai.documentsproviderdemo

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log

class MainActivity : AppCompatActivity() {

    private val REQUEST_CODE = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnOpen = findViewById(R.id.btn_open)
        btnOpen.setOnClickListener { openDocument() }
        val btnCreate = findViewById(R.id.btn_create)
        btnCreate.setOnClickListener { createDocument() }
        val btnOpenTree = findViewById(R.id.btn_open_tree)
        btnOpenTree.setOnClickListener { openDocumentTree() }
        val btnGet = findViewById(R.id.btn_get_content)
        btnGet.setOnClickListener { getContent() }
    }

    /**
     * 打开图片视图
     */
    fun openDocument() {
        val intent = Intent(Intent.ACTION_OPEN_DOCUMENT)
        intent.addCategory(Intent.CATEGORY_OPENABLE)
        intent.type = "image/jpeg"
        startActivityForResult(intent, REQUEST_CODE)
    }

    /**
     * 创建图片视图
     */
    fun createDocument() {
        val intent = Intent(Intent.ACTION_CREATE_DOCUMENT)
        intent.addCategory(Intent.CATEGORY_OPENABLE)
        intent.type = "image/jpeg"
        startActivityForResult(intent, REQUEST_CODE)
    }

    fun openDocumentTree() {
        val intent = Intent(Intent.ACTION_OPEN_DOCUMENT_TREE)
        intent.addCategory(Intent.CATEGORY_OPENABLE)
        intent.type = "image/jpeg"
        startActivityForResult(intent, REQUEST_CODE)
    }

    /**
     * 打开图片视图 含有其他自定义DocumentUI
     */
    fun getContent() {
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.addCategory(Intent.CATEGORY_OPENABLE)
        intent.type = "image/jpeg"
        startActivityForResult(intent, REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode === REQUEST_CODE && resultCode === Activity.RESULT_OK) {
            // The document selected by the user won't be returned in the intent.
            // Instead, a URI to that document will be contained in the return intent
            // provided to this method as a parameter.
            // Pull that URI using resultData.getData().
            var uri: Uri? = null
            if (data != null) {
                uri = data.data
                Log.i("MainActivity", "Uri: " + uri!!.toString())
//                showImage(uri)
            }
        }
    }
}
