package com.example.home_work_lection_8

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.home_work_lection_8.databinding.ListItemBinding

class ListAdapter(private val ctx: MainActivity, private val employees: ArrayList<Employee>):
    RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    private val model = ViewModelProvider(ctx)[EditFragmentModel::class.java]

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding: ListItemBinding = ListItemBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ListItemBinding = ListItemBinding.inflate(inflater)
        return ViewHolder(binding.root)
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)

        // подписка на изменение имени
        model.getName().observe(ctx) {
            recyclerView.post {
                Runnable {
                    val newEmployees = employees.clone() as ArrayList<Employee>
                    newEmployees[it.position].name = it.newName
                    setEmployees(newEmployees)
                }.run()
            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemData: Employee = getItemData(position)
        holder.binding.name.text = itemData.name
        holder.binding.photo.setImageResource(itemData.photo)

        // команда удалить
        holder.binding.deleteCmd.setOnClickListener {
            val newEmployees = employees.clone() as ArrayList<Employee>
            newEmployees.remove(itemData)
            setEmployees(newEmployees)
        }

        // команда редатировать
        holder.binding.editCmd.setOnClickListener {
            val editFrg = EditFragment()
            val params = Bundle()
            params.putString(NAME_KEY, itemData.name)
            params.putInt(POSITION_KEY, position)
            editFrg.arguments = params
            editFrg.show(ctx.supportFragmentManager, "editFrg")
        }

        // команда лайка
        holder.binding.likeCmd.setOnClickListener {
            val imageDrawable = if (itemData.like) {
                itemData.like = false
                R.drawable.like_empty
            } else {
                itemData.like = true
                R.drawable.like
            }

            holder.binding.likeCmd.setBackgroundResource(imageDrawable)
        }
    }

    override fun getItemCount(): Int {
        return employees.size
    }

    private fun getItemData(position: Int): Employee {
        return employees[position]
    }

    /** Метод обновления списка
     * @param newEmployees
     */
    private fun setEmployees(newEmployees: ArrayList<Employee>) {
        val diffCallback = ListDiffUtilCallback(getData(), newEmployees)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        employees.clear()
        employees.addAll(newEmployees)
        diffResult.dispatchUpdatesTo(this)
    }

    companion object {
        const val NAME_KEY = "name"
        const val POSITION_KEY = "position"
    }
}