//
//  ViewController.swift
//  KScheduler
//
//  Created by Ankit Grover on 4/28/16.
//  Copyright © 2016 Kohls. All rights reserved.
//

import UIKit
import ChronosFramework

class ViewController: UITableViewController {
    
    var resourcesArray: [ResourceModel]? = [ResourceModel]()
    let resourcesUserDefault = "ResourcesUserDefaults"
    
    @IBOutlet weak var revealButtonItem: UIBarButtonItem!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        self.setUp()
//        let resource1 = ResourceModel(id: 1, name: "David", status: "Completed", task: "Rack shifting")
//        self.resourcesArray.append(resource1)
//        let resource2 = ResourceModel(id: 1, name: "Joe", status: "Pending", task: "Rack shifting")
//        self.resourcesArray.append(resource2)
//        let resource3 = ResourceModel(id: 1, name: "Sam", status: "Not assigned", task: "Rack shifting")
//        self.resourcesArray.append(resource3)
        
        let userDefaults = NSUserDefaults(suiteName: "group.com.kohls.mcommerce.tasksextension")!
        let resourcesData = userDefaults.objectForKey(resourcesUserDefault) as? NSMutableData
        if let resArray: NSArray = NSKeyedUnarchiver.unarchiveObjectWithData(resourcesData!) as? NSArray {
            for object in resArray {
                let res = object as! ResourceModel
                self.resourcesArray!.append(res)
            }
            //self.resourcesArray = resArray
        }
        // Do any additional setup after loading the view, typically from a nib.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    override func numberOfSectionsInTableView(tableView: UITableView) -> Int {
        return 1
    }
    
    override func tableView(tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        if let resArray = self.resourcesArray {
            return resArray.count
        }
        return 0
    }
    
    override func tableView(tableView: UITableView, cellForRowAtIndexPath indexPath: NSIndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCellWithIdentifier("ResourceCell", forIndexPath: indexPath) as! ResourceTableCellTableViewCell
        if let resourcesArray: [ResourceModel]  = self.resourcesArray! {
            if (!resourcesArray.isEmpty) {
                if let resource: ResourceModel = resourcesArray[indexPath.item] {
                    cell.nameLabel.text! = resource.name!
                    cell.statusLabel.text! = resource.status!
                    cell.taskLabel.text! = resource.task!
                }
            }
        }
        return cell
    }
    
    func setUp() {
        let revealViewController = self.revealViewController()
        if (revealViewController != nil)  {
            self.revealButtonItem.target = revealViewController
            self.revealButtonItem.action = "revealToggle:"
            self.view!.addGestureRecognizer(revealViewController.panGestureRecognizer())
        }
    }

}

