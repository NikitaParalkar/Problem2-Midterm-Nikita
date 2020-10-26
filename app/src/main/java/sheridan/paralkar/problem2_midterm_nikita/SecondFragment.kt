package sheridan.paralkar.problem2_midterm_nikita

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import sheridan.paralkar.problem2_midterm_nikita.databinding.FragmentSecondBinding
import sheridan.paralkar.problem2_midterm_nikita.model.CollegeInfo

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {
    companion object{
        const val COLLEGE_INFO = "college_info"
    }


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentSecondBinding.inflate(inflater, container, false)
        val collegeInfo = arguments?.getSerializable(COLLEGE_INFO) as CollegeInfo
        binding.nameOutput.text = collegeInfo.stdName
        binding.programOutput.text = collegeInfo.program

        binding.backButton.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
        return binding.root
    }

}