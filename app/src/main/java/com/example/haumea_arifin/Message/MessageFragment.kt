package com.example.haumea_arifin.Message

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.haumea_arifin.R
import com.example.haumea_arifin.databinding.FragmentMessageBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MessageFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MessageFragment : Fragment() {
    private var _binding: FragmentMessageBinding? = null
    private val binding get() = _binding!!

    private val messageList = listOf(
        MessageModel("Alya", "Halo! Apa kabar?", "https://avatarapi.runflare.run/public/1"),
        MessageModel("Budi", "Sudah makan?", "https://avatarapi.runflare.run/public/2"),
        MessageModel("Citra", "Jangan lupa tugasnya ya!", "https://avatarapi.runflare.run/public/3"),
        MessageModel("Dika", "Besok kita rapat jam 9", "https://avatarapi.runflare.run/public/4"),
        MessageModel("Eka", "Nice job kemarin!", "https://avatarapi.runflare.run/public/5"),
        MessageModel("Fajar", "Lagi ngapain?", "https://avatarapi.runflare.run/public/6"),
        MessageModel("Gita", "Boleh minta tolong?", "https://avatarapi.runflare.run/public/7"),
        MessageModel("Hana", "Lihat email ya", "https://avatarapi.runflare.run/public/8"),
        MessageModel("Irfan", "Oke noted", "https://avatarapi.runflare.run/public/9"),
        MessageModel("Joko", "Sampai jumpa besok", "https://avatarapi.runflare.run/public/10")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMessageBinding.inflate(
            inflater, container, false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.apply {
            title = "Message"
        }

        val adapter = MessageAdapter(requireContext(), messageList)
        binding.listMessageItems.adapter = adapter
    }


}