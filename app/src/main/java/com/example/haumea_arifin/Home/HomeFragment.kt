package com.example.haumea_arifin.Home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.example.haumea_arifin.AuthActivity
import com.example.haumea_arifin.Home.pertemuan4.FourthActivity
import com.example.haumea_arifin.Home.pertemuan5.FifthActivity
import com.example.haumea_arifin.Home.pertemuan7.SevenActivity
import com.example.haumea_arifin.databinding.FragmentHomeBinding
import androidx.appcompat.app.AppCompatActivity

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.apply {
            title = "Home"
        }
        // Navigasi ke FourthActivity dengan mengirim data
        binding.btnToFourth.setOnClickListener {
            val intent = Intent(requireContext(), FourthActivity::class.java)
            intent.putExtra("name", "Politeknik Caltex Riau")
            intent.putExtra("from", "Rumbai")
            intent.putExtra("age", 25)
            startActivity(intent)
        }

        // Navigasi ke FifthActivity
        binding.btnToFifth.setOnClickListener {
            val intent = Intent(requireContext(), FifthActivity::class.java)
            startActivity(intent)
        }

        // Navigasi ke SevenActivity
        binding.btnToSeven.setOnClickListener {
            val intent = Intent(requireContext(), SevenActivity::class.java)
            startActivity(intent)
        }

        // Logout dengan konfirmasi
        binding.btnLogout.setOnClickListener {
            AlertDialog.Builder(requireContext())
                .setTitle("Logout")
                .setMessage("Yakin mau logout?")
                .setPositiveButton("Ya") { dialog, _ ->

                    // Hapus data sesi pengguna
                    val sharedPref = requireContext()
                        .getSharedPreferences(
                            "user_pref",
                            android.content.Context.MODE_PRIVATE
                        )

                    sharedPref.edit()
                        .clear()
                        .apply()

                    dialog.dismiss()

                    // Kembali ke AuthActivity
                    val intent = Intent(
                        requireContext(),
                        AuthActivity::class.java
                    )

                    // Hapus halaman sebelumnya dari back stack
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or
                            Intent.FLAG_ACTIVITY_CLEAR_TASK

                    startActivity(intent)
                }
                .setNegativeButton("Tidak") { dialog, _ ->
                    dialog.dismiss()
                }
                .show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
