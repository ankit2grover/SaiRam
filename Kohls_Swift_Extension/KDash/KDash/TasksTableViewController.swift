//
//  TasksTableViewController.swift
//  KDash
//
//  Created by Ankit Grover on 4/26/16.
//  Copyright © 2016 Kohls. All rights reserved.
//

import Foundation
import UIKit

class TasksTableViewController : UITableViewController {
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
        // tasksTableView.dataSource = self
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    // Mark : Properties
    
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

    
    // Mark: Actions
    @IBAction func showActionView(sender: UIBarButtonItem) {
        let activiyItems = ["Task Sprint1"]
        let activityViewController = UIActivityViewController(activityItems: activiyItems, applicationActivities: nil)
        self.presentViewController(activityViewController, animated: true, completion: nil)
    }
    
}

