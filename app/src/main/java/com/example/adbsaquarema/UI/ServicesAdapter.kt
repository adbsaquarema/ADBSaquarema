package com.example.adbsaquarema.UI

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.adbsaquarema.Data.Services
import com.example.adbsaquarema.databinding.ServiceslisrtitemBinding

class ServicesAdapter(
    private val context: Context,
    private val ServicesList: MutableList<Services>,
    private val onItemClick: OnItemClick
) : Adapter<ServicesViewHolder>() {

    interface OnItemClick {
        fun OnItemClicked(Service: Services)

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServicesViewHolder {
        val view = ServiceslisrtitemBinding
            .inflate(LayoutInflater.from(context), parent, false)
        return ServicesViewHolder(view)
    }

    override fun getItemCount() = ServicesList.size

    override fun onBindViewHolder(holder: ServicesViewHolder, position: Int) {

        holder.bind(ServicesList[position])
        holder.itemView.setOnClickListener {


            onItemClick.OnItemClicked(ServicesList[position])


        }


    }


}

class ServicesViewHolder(binding: ServiceslisrtitemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    val imgService = binding.imgItem
    val txtService = binding.txtItem

    fun bind(service: Services) {


        imgService.setImageResource(service.icon!!)
        txtService.text = service.name


    }

}

