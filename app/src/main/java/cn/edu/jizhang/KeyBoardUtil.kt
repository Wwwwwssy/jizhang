@file:Suppress("DEPRECATION")

package cn.edu.jizhang


import android.inputmethodservice.Keyboard
import android.inputmethodservice.KeyboardView
import android.inputmethodservice.KeyboardView.OnKeyboardActionListener
import android.text.InputType
import android.view.View
import android.widget.EditText


@Suppress("DEPRECATION")
class KeyBoardUtils(private val keyboardView: KeyboardView, private val editText: EditText) {
    private val k1: Keyboard//自定义键盘

    interface OnEnsureListener {
        fun onEnsure()
    }

    var onEnsureListener: OnEnsureListener? = null
    @JvmName("setOnEnsureListener1")
    fun setOnEnsureListener(onEnsureListener: OnEnsureListener?) {
        this.onEnsureListener = onEnsureListener
    }

    var listener: OnKeyboardActionListener = object : OnKeyboardActionListener {
        override fun onPress(primaryCode: Int) {}
        override fun onRelease(primaryCode: Int) {}
        override fun onText(text: CharSequence) {}
        override fun swipeLeft() {}
        override fun swipeRight() {}
        override fun swipeDown() {}
        override fun swipeUp() {}
        override fun onKey(primaryCode: Int, keyCodes: IntArray) {
            val edittext1 = editText.text
            val edittextstart = editText.selectionStart
            when (primaryCode) {
                Keyboard.KEYCODE_DELETE -> if (edittext1 != null && edittext1.length > 0) {
                    if (edittextstart > 0) {
                        edittext1.delete(edittextstart - 1, edittextstart)
                    }
                }
                Keyboard.KEYCODE_CANCEL -> edittext1!!.clear()
                Keyboard.KEYCODE_DONE -> onEnsureListener!!.onEnsure() //通过接口回调的方法，当点击确定时，可以调用这个方法
                else -> edittext1!!.insert(edittextstart, Character.toString(primaryCode.toChar()))
            }
        }

    }



    //    显示键盘
    fun showKeyboard() {
        val visibility = keyboardView.visibility
        if (visibility == View.INVISIBLE || visibility == View.GONE) {
            keyboardView.visibility = View.VISIBLE
        }
    }

    //    隐藏键盘
    fun hideKeyboard() {
        val visibility = keyboardView.visibility
        if (visibility == View.VISIBLE || visibility == View.INVISIBLE) {
            keyboardView.visibility = View.GONE
        }
    }

    init {
        editText.inputType = InputType.TYPE_NULL //取消弹出系统键盘
        k1 = Keyboard(editText.context, R.xml.key)
        keyboardView.keyboard = k1 //设置要显示键盘的样式
        keyboardView.isEnabled = true
        keyboardView.isPreviewEnabled = false
        keyboardView.setOnKeyboardActionListener(listener) //设置键盘按钮被点击了的监听
    }
}
