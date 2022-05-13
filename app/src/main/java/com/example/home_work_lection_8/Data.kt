package com.example.home_work_lection_8

data class Employee(val id: Int, var name: String, val photo: Int, var like: Boolean)

fun getData(): ArrayList<Employee> {
    return arrayListOf(
        Employee(1,"Василий", R.drawable.photo_1, false),
        Employee(2,"Андрей", R.drawable.photo_3, true),
        Employee(3,"Сергей", R.drawable.photo_2, false),
        Employee(4,"Елена", R.drawable.photo_1, false),
        Employee(5,"Наталия", R.drawable.photo_3, false),
        Employee(6,"Павел", R.drawable.photo_1, true),
        Employee(7,"Василий", R.drawable.photo_2, false),
        Employee(8,"Александр", R.drawable.photo_1, false),
        Employee(9,"Святослав", R.drawable.photo_3, false),
        Employee(10,"Анатолий", R.drawable.photo_1, false),
        Employee(11,"Игорь", R.drawable.photo_2, false),
        Employee(12,"Ирина", R.drawable.photo_1, false),
        Employee(13,"Валентина", R.drawable.photo_1, false),
        Employee(14,"Юлия", R.drawable.photo_2, true),
        Employee(15,"Борис", R.drawable.photo_3, false),
        Employee(16,"Александр", R.drawable.photo_1, false),
        Employee(17,"Павел", R.drawable.photo_3, false),
        Employee(18,"Юлия", R.drawable.photo_1, true),
        Employee(19,"Наталия", R.drawable.photo_2, false),
        Employee(20,"Татьяна", R.drawable.photo_1, false),
        Employee(21,"Сергей", R.drawable.photo_3, false),
    )
}