package stanic.miris.fragment.config

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_commands_config.view.*
import stanic.miris.R
import stanic.miris.fragment.ConfigFragment
import stanic.miris.service.ServerService

class CommandsConfigFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_commands_config, container, false).apply {
            return_commands_button.setOnClickListener {
                if (activity != null) {
                    val transaction = activity!!.supportFragmentManager.beginTransaction()
                    transaction.replace(R.id.fragmentLayout, ConfigFragment())
                    transaction.commit()
                }
            }

            enable_button.setOnClickListener {
                if (write_command.text.isEmpty()) Toast.makeText(context, "Write the command!", Toast.LENGTH_SHORT).show()
                else {
                    ServerService().sendCommand(write_command.text.toString(), 1)
                    Toast.makeText(context, "Enabled!", Toast.LENGTH_SHORT).show()

                    val transaction = activity!!.supportFragmentManager.beginTransaction()
                    transaction.replace(R.id.fragmentLayout, ConfigFragment())
                    transaction.commit()
                }
            }
            disable_button.setOnClickListener {
                if (write_command.text.isEmpty()) Toast.makeText(context, "Write the command!", Toast.LENGTH_SHORT).show()
                else {
                    ServerService().sendCommand(write_command.text.toString(), 2)
                    Toast.makeText(context, "Disabled!", Toast.LENGTH_SHORT).show()

                    val transaction = activity!!.supportFragmentManager.beginTransaction()
                    transaction.replace(R.id.fragmentLayout, ConfigFragment())
                    transaction.commit()
                }
            }
        }
    }

}