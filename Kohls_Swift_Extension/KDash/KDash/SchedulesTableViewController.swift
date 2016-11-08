//
//  SchedulesTableViewController.swift
//  KDash
//
//  Created by Ankit Grover on 5/1/16.
//  Copyright © 2016 Kohls. All rights reserved.
//

import Foundation
import UIKit

class ScheduleTableViewController : UITableViewController {
    
    
    // Mark : Properties
    
    override func viewWillAppear(animated: Bool) {
        self.navigationController?.navigationBar.hidden = false
        self.navigationItem.title = "Tasks Table"
        //self.navigationItem.backBarButtonItem?.title = "Exit"
    }
    
    override func prepareForSegue(segue: UIStoryboardSegue, sender: AnyObject?) {
        
    }
    
    @IBOutlet weak var tasksTableView: UITableView!
    
    
    var dummyTable : [(name: String, description: String)] = [("name1" , "dictionary1"), ("name2" , "dictionary2"), ("name3" , "dictionary3"), ("name4" , "dictionary4")]
    
    let noOfRows = 4
    
    override func numberOfSectionsInTableView(tableView: UITableView) -> Int {
        return 1
    }
    
    override func tableView(tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return noOfRows
    }
    
    override func tableView(tableView: UITableView, cellForRowAtIndexPath indexPath: NSIndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCellWithIdentifier("TasksTableViewCell", forIndexPath: indexPath) as! TasksTableViewCell
        
        cell.nameTextView.text! = dummyTable[indexPath.row].name
        cell.descTextView.text! = dummyTable[indexPath.row].description
        return cell
    }

    @IBAction func backAction(sender: UIBarButtonItem) {
        self.navigationController?.popViewControllerAnimated(true)
    }
    
    override func tableView(tableView: UITableView, didSelectRowAtIndexPath indexPath: NSIndexPath) {
        let activiyItems = ["Task Sprint1"]
        let activityViewController = UIActivityViewController(activityItems: activiyItems, applicationActivities: nil)
        self.presentViewController(activityViewController, animated: true, completion: nil)
    }
    
}