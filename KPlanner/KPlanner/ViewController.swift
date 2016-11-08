//
//  ViewController.swift
//  KPlanner
//
//  Created by Jui Joshi on 4/22/16.
//  Copyright (c) 2016 Jui Joshi. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }

   @IBOutlet weak var taskname: UITextField!

    @IBOutlet weak var assignee: UITextField!
    
    @IBOutlet weak var date: UITextField!
    
    
    @IBAction func submitTask(sender: AnyObject) {
        print(sender, terminator: "")
          
        let task = PlannerData(taskname: taskname.text!, assignee: assignee.text!, date: date.text!)
        
        saveData(task)
        
        let task2 = getData()
        print(task2.assignee, terminator: "")
    }
    
    func saveData(task: PlannerData) {
        //var userDefaults = NSUserDefaults(suiteName: "com.kohls.tkmagz4.KPlanner")
        let userDefaults = NSUserDefaults.standardUserDefaults()
        let encodedData = NSKeyedArchiver.archivedDataWithRootObject(task)
        userDefaults.setObject(encodedData, forKey: "tasks")
        userDefaults.synchronize()
    }
    
    func getData() -> PlannerData {
        //var userDefaults = NSUserDefaults(suiteName: "com.kohls.tkmagz4.KPlanner")
        let userDefaults = NSUserDefaults.standardUserDefaults()
        if let watchlistData : AnyObject = userDefaults.objectForKey("tasks") {
            if let watchlist : AnyObject = NSKeyedUnarchiver.unarchiveObjectWithData(watchlistData as! NSData) {
                return watchlist as! PlannerData
            }
        }
        return PlannerData(taskname: "", assignee:"", date: "")
    }
    
    
}

