package com.geovane.appfulldacorrecao.Resource

import com.geovane.appfulldacorrecao.model.Schedule
import javax.security.auth.callback.Callback

class DataSourceSchedule {

    companion object {
        fun creatSchedule(schedule: Schedule, callback: (list: ArrayList<Schedule>) -> Unit) {
            var list = ArrayList<Schedule>()
            list.add(schedule)
            callback(list)
        }

        fun createSchedule(schedule: Schedule, function: () -> Unit) {

        }
    }
}