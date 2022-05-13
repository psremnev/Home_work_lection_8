package com.example.home_work_lection_8

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.example.home_work_lection_8.databinding.FragmentEditBinding

class EditFragment : DialogFragment() {
    private lateinit var binding: FragmentEditBinding
    private lateinit var model: EditFragmentModel
    private lateinit var name: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        model = ViewModelProvider(requireActivity())[EditFragmentModel::class.java]
        binding = FragmentEditBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // установить имя в поле
        binding.editName.setText(arguments?.getString(ListAdapter.NAME_KEY))

        // сохранить имя
        binding.okBtn.setOnClickListener {
            model.setName(object: IChangeName {
                override var newName = binding.editName.text.toString()
                override var position = arguments!!.getInt(ListAdapter.POSITION_KEY)
            })
            parentFragmentManager.beginTransaction().remove(this).commit()
        }
    }
}