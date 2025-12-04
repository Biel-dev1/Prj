package com.ffxtreme.app.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ffxtreme.app.databinding.FragmentMiscBinding

class MiscFragment : Fragment() {

    private var _binding: FragmentMiscBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMiscBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
    }

    private fun setupUI() {
        binding.tvSpeedValue.text = "${binding.sliderSpeed.value.toInt()}x"

        binding.sliderSpeed.addOnChangeListener { _, value, _ ->
            binding.tvSpeedValue.text = "${value.toInt()}x"
        }

        binding.switchSpeedHack.setOnCheckedChangeListener { _, isChecked ->
            binding.sliderSpeed.isEnabled = isChecked
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
