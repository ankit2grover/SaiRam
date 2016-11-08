//
//  MonthTasksData.swift
//  Calendar
//
//  Created by Jui Joshi on 5/6/16.
//  Copyright © 2016 Unicorn. All rights reserved.
//

import Foundation

class MonthTasksData {
    
    var taskDate : String
    var monthTasks : [Tasks]
    
    init (taskDate: String, monthTasks: [Tasks]) {

        self.taskDate = taskDate
        self.monthTasks = monthTasks
    }
    
}
