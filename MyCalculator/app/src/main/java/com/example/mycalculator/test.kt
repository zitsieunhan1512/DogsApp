package com.example.mycalculator

import android.text.TextUtils.indexOf

fun main() {
    var s: String = "    -8  - 999    "
    s = s.replace(" ", "")
    var kt=false
    if(s.startsWith("-")){
        s=s.drop(1)
        kt=true
    }
    var splitValue : List<String>
    splitValue=s.split("-")

    if (s.contains("+"))
        splitValue = s.split("+")
    if (s.contains("*"))
        splitValue = s.split("*")
    if (s.contains("/"))
        splitValue = s.split("/")
    var one = splitValue[0].toDouble()
    var two = splitValue[1].toDouble()
    if (kt) one *= -1
    if (s.contains("-")) {
        two *= -1
    }
    if (s.contains("*"))
        print(one*two)
    if (s.contains("/"))
        print(one/two)
    else
        print(one+two)
}
