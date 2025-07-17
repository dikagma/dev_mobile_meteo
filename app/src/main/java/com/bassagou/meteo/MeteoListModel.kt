package com.bassagou.meteo
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
    class MeteoListModel(
        context: Context,
        private val resource: Int,
        private val listItems: List<MeteoItem>
    ) : ArrayAdapter<MeteoItem>(context, resource, listItems) {

        companion object {
            val images: Map<String, Int> = mapOf(
                "Clear" to R.drawable.clear,
                "Clouds" to R.drawable.clouds,
                "Rain" to R.drawable.rain,
                "thunderstormspng" to R.drawable.thunderstormspng
            )
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            Log.i("MyLog", ".......................$position")

            val listItem = convertView ?: LayoutInflater.from(context).inflate(resource, parent, false)

            val imageView = listItem.findViewById<ImageView>(R.id.imageView)
            val textViewTempMax = listItem.findViewById<TextView>(R.id.textViewTempMAX)
            val textViewTempMin = listItem.findViewById<TextView>(R.id.textViewTempMin)
            val textViewPression = listItem.findViewById<TextView>(R.id.textViewPression)
            val textViewHumidite = listItem.findViewById<TextView>(R.id.textViewHumidite)
            val textViewDate = listItem.findViewById<TextView>(R.id.textViewDate)

            val item = listItems[position]
            val key = item.image

            key?.let {
                images[it]?.let { resId -> imageView.setImageResource(resId) }
            }

            textViewTempMax.text = "${item.tempMax} °C"
            textViewTempMin.text = "${item.tempMin} °C"
            textViewPression.text = "${item.pression} hPa"
            textViewHumidite.text = "${item.humidite} %"
            textViewDate.text = item.date.toString()

            return listItem
        }
    }

