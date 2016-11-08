//
//  ActionViewController.swift
//  Tasks
//
//  Created by Ankit Grover on 4/28/16.
//  Copyright © 2016 Kohls. All rights reserved.
//

import UIKit
import MobileCoreServices
import ChronosFramework


class ActionViewController: UIViewController, UIPickerViewDataSource, UIPickerViewDelegate {

   
    @IBOutlet weak var extensionTextView: UITextView!
    @IBOutlet weak var resPickerView: UIPickerView!
    
    var resourcesArray = [ResourceModel]()
    let resourcesUserDefault = "ResourcesUserDefaults"

    override func viewDidLoad() {
        super.viewDidLoad()
        self.resPickerView.delegate = self
        self.resPickerView.dataSource = self
        self.createResArrayFromUserDefaults()
        let textItem = self.extensionContext!.inputItems[0] as! NSExtensionItem
        let itemProvider = textItem.attachments![0] as! NSItemProvider
        if (itemProvider.hasItemConformingToTypeIdentifier(kUTTypeText as String)) {
            itemProvider.loadItemForTypeIdentifier(kUTTypeText as String, options: nil, completionHandler: {(text, error ) -> Void in
                let shareAction = text as? String
                if shareAction != nil {
                    dispatch_async(dispatch_get_main_queue(), {
                        self.extensionTextView.text! = shareAction!
                    })
                }
            })
        }
        
    }
    
    override func viewDidAppear(animated: Bool) {
        //self.generateDummyResources()
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }

    @IBAction func done() {
        // Return any edited content to the host app.
        // This template doesn't do anything, so we just echo the passed in items.
        self.extensionContext!.completeRequestReturningItems(self.extensionContext!.inputItems, completionHandler: nil)
    }
    
    
    @IBAction func addTaskAction(sender: UIButton) {
        let selectedRow = self.resPickerView.selectedRowInComponent(0)
        self.resourcesArray[selectedRow].task! = self.extensionTextView.text!
        self.resourcesArray[selectedRow].status! = "Assigned"
        print("Saving data in shared defaults \(resourcesArray) ")
        let userDefaults = NSUserDefaults(suiteName: "group.com.kohls.mcommerce.tasksextension")!
        userDefaults.setObject(self.archiveResourcesData(), forKey: resourcesUserDefault)
        userDefaults.synchronize()
        self.extensionContext!.completeRequestReturningItems(self.extensionContext!.inputItems, completionHandler: nil)
    }
    
    func archiveResourcesData() -> NSData {
        //self.resourcesArray[0] =
        return NSKeyedArchiver.archivedDataWithRootObject(self.resourcesArray)
    }
    
    func generateDummyResources() {
        let resource1 = ResourceModel(id: 1, name: "Rahul", status: "Not assigned", task: "No Task")
        self.resourcesArray.append(resource1)
        let resource2 = ResourceModel(id: 2, name: "Dalwinder", status: "Not assigned", task: "No Task")
        self.resourcesArray.append(resource2)
        let resource3 = ResourceModel(id: 3, name: "Sukesh", status: "Not assigned", task: "No Task")
        self.resourcesArray.append(resource3)
    }
    
    func numberOfComponentsInPickerView(pickerView: UIPickerView) -> Int {
        return 1
    }
    
    func pickerView(pickerView: UIPickerView, numberOfRowsInComponent component: Int) -> Int {
        return self.resourcesArray.count
    }
    
    func pickerView(pickerView: UIPickerView, titleForRow row: Int, forComponent component: Int) -> String? {
        return self.resourcesArray[row].name!
    }
    
    func createResArrayFromUserDefaults() {
        let userDefaults = NSUserDefaults(suiteName: "group.com.kohls.mcommerce.tasksextension")!
        
        if let resourcesData = userDefaults.objectForKey(resourcesUserDefault) as? NSMutableData {
            if let resArray: NSArray = NSKeyedUnarchiver.unarchiveObjectWithData(resourcesData) as? NSArray {
                for object in resArray {
                    let res = object as! ResourceModel
                    self.resourcesArray.append(res)
                }
                //self.resourcesArray = resArray
            }
        } else {
            self.generateDummyResources()
        }
    }

}
