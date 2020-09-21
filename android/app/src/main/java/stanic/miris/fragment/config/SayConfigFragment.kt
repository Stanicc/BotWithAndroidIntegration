package stanic.miris.fragment.config

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_say_config.view.*
import stanic.miris.R
import stanic.miris.fragment.ConfigFragment
import stanic.miris.service.ServerService

class SayConfigFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_say_config, container, false).apply {
            return_say_button.setOnClickListener {
                if (activity != null) {
                    val transaction = activity!!.supportFragmentManager.beginTransaction()
                    transaction.replace(R.id.fragmentLayout, ConfigFragment())
                    transaction.commit()
                }
            }

            say_button.setOnClickListener {
                if (write_say.text.isEmpty()) Toast.makeText(context, "Write the text!", Toast.LENGTH_SHORT).show()
                else {
                    ServerService().sendSay(write_say.text.toString())
                    Toast.makeText(context, "Success!", Toast.LENGTH_SHORT).show()

                    val transaction = activity!!.supportFragmentManager.beginTransaction()
                    transaction.replace(R.id.fragmentLayout, ConfigFragment())
                    transaction.commit()
                }
            }
        }
    }

}