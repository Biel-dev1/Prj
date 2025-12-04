package com.ffxtreme.app.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.ffxtreme.app.R
import com.ffxtreme.app.databinding.FragmentConfigBinding

class ConfigFragment : Fragment() {

    private var _binding: FragmentConfigBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentConfigBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
    }

    private fun setupUI() {
        binding.btnSave.setOnClickListener {
            Toast.makeText(requireContext(), R.string.config_saved, Toast.LENGTH_SHORT).show()
        }

        binding.btnLoad.setOnClickListener {
            Toast.makeText(requireContext(), R.string.config_loaded, Toast.LENGTH_SHORT).show()
        }

        binding.btnReset.setOnClickListener {
            Toast.makeText(requireContext(), R.string.config_reset, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
