package com.github.mishkaff89.fitnessnote.utils

import android.content.Intent
import com.github.mishkaff89.fitnessnote.entity.ExerciseItem

object ShareHelper {
    fun shareShopList(shopListItem: List<ExerciseItem>, listName: String , time: String): Intent {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plane"
        intent.apply {
            putExtra(Intent.EXTRA_TEXT, makeShareText(shopListItem, listName, time))
        }
        return intent
    }

    private fun makeShareText(exerciseItem: List<ExerciseItem>, listName: String, time: String ): String{
        val sBuilder = StringBuilder()
        sBuilder.append("<<${listName}>>")
        sBuilder.append("\n")
        sBuilder.append(time)
        sBuilder.append("\n")
        var counter = 0
        exerciseItem.forEach{

            if (it.type == 1){
                sBuilder.append("\n")
                sBuilder.append("${++counter} - ${it.name} - Кардио ")
                sBuilder.append("\n")
                sBuilder.append("   ${it.value1_1} - ${it.value2_1} км")
                sBuilder.append("\n")

            } else{
                sBuilder.append("\n")
                sBuilder.append("${++counter} - ${it.name} - Зал ")
                sBuilder.append("\n")
                sBuilder.append("   ${it.value1_1} кг - ${it.value2_1} ")
                sBuilder.append("\n")

                if (it.value1_2.isNotEmpty()){
                    sBuilder.append("   ${it.value1_2} кг - ${it.value2_2} ")
                    sBuilder.append("\n")
                }
                if (it.value1_3.isNotEmpty()){
                    sBuilder.append("   ${it.value1_3} кг - ${it.value2_3} ")
                    sBuilder.append("\n")
                }
                if (it.value1_4.isNotEmpty()){
                    sBuilder.append("   ${it.value1_4} кг - ${it.value2_4} ")
                    sBuilder.append("\n")
                }
                if (it.value1_5.isNotEmpty()){
                    sBuilder.append("   ${it.value1_2} кг - ${it.value2_2} ")
                    sBuilder.append("\n")
                }
                if (it.value1_6.isNotEmpty()){
                    sBuilder.append("   ${it.value1_6} кг - ${it.value2_6} ")
                    sBuilder.append("\n")
                }
                if (it.value1_7.isNotEmpty()){
                    sBuilder.append("   ${it.value1_7} кг - ${it.value2_7} ")
                    sBuilder.append("\n")
                }
                if (it.value1_8.isNotEmpty()){
                    sBuilder.append("   ${it.value1_8} кг - ${it.value2_8} ")
                    sBuilder.append("\n")
                }
                if (it.value1_9.isNotEmpty()){
                    sBuilder.append("   ${it.value1_9} кг - ${it.value2_9} ")
                    sBuilder.append("\n")
                }
                if (it.value1_10.isNotEmpty()){
                    sBuilder.append("   ${it.value1_10} кг - ${it.value2_10} ")
                    sBuilder.append("\n")
                }

            }

        }
        return sBuilder.toString()
    }
}