//
//  DetailsViewController.swift
//  Calendar
//
//  Created by Jui Joshi on 5/4/16.
//  Copyright © 2016 Unicorn. All rights reserved.
//

import UIKit

class DetailsViewController: UIViewController , UITableViewDelegate, UITableViewDataSource{
    
    var value : String = ""
    
    var dateTasks : [Tasks]!
    
    @IBOutlet weak var tableView: UITableView!
   
    override func viewDidLoad() {
        super.viewDidLoad()
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    func tableView(tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return dateTasks.count
    }
    
    func tableView(tableView: UITableView, cellForRowAtIndexPath indexPath: NSIndexPath) -> UITableViewCell {
        
        let cell = self.tableView.dequeueReusableCellWithIdentifier("TaskCell") as! TaskCellView!
        
        cell.taskName?.text = dateTasks[indexPath.row].taskName
        cell.taskDescription?.text = dateTasks[indexPath.row].description
        cell.estimatedHours?.text = String(dateTasks[indexPath.row].estimatedHours)
        cell.endDate?.text = dateTasks[indexPath.row].endDate
        cell.Scheduled?.text = String(dateTasks[indexPath.row].scheduled)
        
        
        return cell
    }
    
    
    func tableView(tableView: UITableView, didSelectRowAtIndexPath indexPath: NSIndexPath) {
        let task = self.dateTasks[indexPath.item]
        self.callExtensionsWithTask(task.taskName, taskId: "1")
        

    }
    
    func callExtensionsWithTask(taskName: String? = nil, taskId: String? = nil) {
        
        var taskInfo: [String] = [String]()
        
        taskInfo.append(taskName!)
        
        taskInfo.append(taskId!)
        
        let activityViewController = UIActivityViewController(activityItems: taskInfo, applicationActivities: nil)
        
        self.presentViewController(activityViewController, animated: true, completion: nil)
        
    }
    


}