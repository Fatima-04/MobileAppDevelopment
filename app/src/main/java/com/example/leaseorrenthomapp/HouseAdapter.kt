package com.example.leaseorrenthomapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class HouseAdapter(private val context: Context, private val dataSource: List<HouseItem>) : BaseAdapter() {

    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
        return dataSource.size
    }

    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val rowView = convertView ?: inflater.inflate(R.layout.item_house, parent, false)

        val imageView = rowView.findViewById<ImageView>(R.id.imageView)
        val textAddress = rowView.findViewById<TextView>(R.id.textAddress)
        val textPrice = rowView.findViewById<TextView>(R.id.textPrice)

        val houseItem = getItem(position) as HouseItem

        imageView.setImageResource(houseItem.imageResId)
        textAddress.text = houseItem.address
        textPrice.text = houseItem.price

        return rowView
    }
}
