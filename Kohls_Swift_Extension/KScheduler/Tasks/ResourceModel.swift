//
//  ResourceModel.swift
//  KScheduler
//
//  Created by Ankit Grover on 5/3/16.
//  Copyright © 2016 Kohls. All rights reserved.
//

import UIKit


class ResourceModel: NSObject, NSCoding {
    
    struct Keys {
        static let Name = "Name"
        static let Id = "Id"
        static let Status = "Status"
        static let Task = "Task"
    }

    var id: Int?
    var name : String?
    var status : String?
    var task: String?
    
    init(id:Int, name:String, status:String, task:String) {
        self.id = id
        self.name = name
        self.status = status
        self.task = task
    }
    
    required init(coder unarchiver:NSCoder) {
        super.init()
        self.name = unarchiver.decodeObjectForKey(Keys.Name) as? String
        self.id = unarchiver.decodeObjectForKey(Keys.Id) as? Int
        self.status = unarchiver.decodeObjectForKey(Keys.Status) as? String
        self.task = unarchiver.decodeObjectForKey(Keys.Task) as? String
    }
    
    func encodeWithCoder(aCoder: NSCoder) {
        aCoder.encodeObject(self.name, forKey: Keys.Name)
        aCoder.encodeObject(self.id, forKey: Keys.Id)
        aCoder.encodeObject(self.status, forKey: Keys.Status)
        aCoder.encodeObject(self.task, forKey: Keys.Task)
    }
}
