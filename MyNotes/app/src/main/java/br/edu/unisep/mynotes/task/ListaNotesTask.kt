package br.edu.unisep.mynotes.task

import android.os.AsyncTask
import br.edu.unisep.mynotes.model.vo.NoteVO
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import javax.net.ssl.HttpsURLConnection

class ListaNotesTask(val callback : (List<NoteVO>?) -> Unit) : AsyncTask<Unit, Unit, List<NoteVO> >() {

    val URL_WS = "https://mynotesfefb.firebaseapp.com/list"

    override fun doInBackground(vararg params: Unit?): List<NoteVO> {

        val url = URL(URL_WS)

        val con = url.openConnection() as HttpURLConnection
        con.connect()

        val reader = InputStreamReader(con.inputStream)
        val gson = Gson()

        val tipo = object : TypeToken< List<NoteVO> >(){}.type

        val retorno = gson.fromJson< List<NoteVO> >(reader, tipo)

        con.disconnect()

        return retorno
    }


    override fun onPostExecute(result: List<NoteVO>?) {
        callback(result)
    }


}