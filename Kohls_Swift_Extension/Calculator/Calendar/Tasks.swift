//
//  Tasks.swift
//  Calendar
//
//  Created by Jui Joshi on 5/6/16.
//  Copyright © 2016 Unicorn. All rights reserved.
//

import Foundation

class Tasks {
    
    var taskName : String = ""
    var scheduled : Bool
    var estimatedHours : Double = 0.0
    var endDate : String = "" // Date??
    var description : String = ""
    var taskId: Int = -1
    
    init(taskName: String, scheduled: Bool, estimatedHours: Double, endDate: String, description: String) {
        
        self.taskName = taskName
        self.scheduled = scheduled
        self.estimatedHours = estimatedHours
        self.endDate = endDate
        self.description = description
    }
    
}
