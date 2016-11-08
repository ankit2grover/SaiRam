//
//  TaskData.swift
//  KPlanner
//
//  Created by Jui Joshi on 4/24/16.
//  Copyright (c) 2016 Jui Joshi. All rights reserved.
//

import Foundation

class PlannerData: NSObject, NSCoding {
    var taskname: NSString!
    var assignee: NSString!
    var date: NSString!
    
    
    init(taskname: NSString, assignee:NSString, date: NSString) {
        self.taskname = taskname
        self.assignee = assignee
        self.date = date
    }
    
    required init?(coder aDecoder: NSCoder) {
        self.taskname  = aDecoder.decodeObjectForKey("taskname") as! String
        self.assignee  = aDecoder.decodeObjectForKey("assignee") as! String
        self.date  = aDecoder.decodeObjectForKey("date") as! String
    }
    
    func encodeWithCoder(aCoder: NSCoder) {
        aCoder.encodeObject(self.taskname, forKey: "taskname")
        aCoder.encodeObject(self.assignee, forKey: "assignee")
        aCoder.encodeObject(self.date, forKey: "date")
    }
}
