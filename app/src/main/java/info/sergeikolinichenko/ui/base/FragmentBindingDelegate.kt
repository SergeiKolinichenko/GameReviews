package info.sergeikolinichenko.ui.base

import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import androidx.viewbinding.ViewBinding
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

/** Created by Sergei Kolinichenko on 13.06.2023 at 20:14 (GMT+3) **/

inline fun <reified T : ViewBinding> Fragment.viewBinding() =
  FragmentBindingDelegate(this, T::class.java)

class FragmentBindingDelegate<T : ViewBinding>(
  private val fragment: Fragment,
  private val bindingFactory: Class<T>
) : ReadOnlyProperty<Fragment, T> {

  private var binding: T? = null

  init {
    fragment.lifecycle.addObserver(object : LifecycleEventObserver {
      override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        if (event == Lifecycle.Event.ON_CREATE) {
          fragment.viewLifecycleOwnerLiveData.observe(fragment) {
            it.lifecycle.addObserver(object : LifecycleEventObserver {
              override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
                if (event == Lifecycle.Event.ON_DESTROY) {
                  binding = null
                }
              }
            })
          }
        }
      }
    })
  }

  @Suppress("UNCHECKED_CAST")
  override fun getValue(thisRef: Fragment, property: KProperty<*>): T {

    if (binding == null) {
      binding = bindingFactory.getMethod("bind", View::class.java)
        .invoke(null, thisRef.requireView()) as T
    }
    return binding ?: throw RuntimeException("binding Fragment $fragment equal null")

  }
}
