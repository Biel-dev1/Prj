package com.ffxtreme.app.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ffxtreme.app.databinding.FragmentVisualBinding

class VisualFragment : Fragment() {

    private var _binding: FragmentVisualBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentVisualBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
    }

    private fun setupUI() {
        binding.switchEspPlayers.setOnCheckedChangeListener { _, isChecked ->
            binding.switchBox2d3d.isEnabled = isChecked
            binding.switchAimLines.isEnabled = isChecked
            binding.switchPlayerName.isEnabled = isChecked
            binding.switchHealthBar.isEnabled = isChecked
            binding.switchDistance.isEnabled = isChecked
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
