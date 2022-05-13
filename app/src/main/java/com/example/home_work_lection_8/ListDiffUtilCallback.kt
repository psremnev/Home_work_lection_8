package com.example.home_work_lection_8

import androidx.recyclerview.widget.DiffUtil

class ListDiffUtilCallback(private val oldList: List<Employee>, private val newList: List<Employee>) :
    DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val old: Employee = oldList[oldItemPosition]
        val new: Employee = newList[newItemPosition]
        return old.id == new.id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val old: Employee = oldList[oldItemPosition]
        val new: Employee = newList[newItemPosition]
        return (old.name == new.name && old.photo == new.photo)
    }

}