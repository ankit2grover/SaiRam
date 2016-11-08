//
//  ActionViewController.swift
//  PlannerExtension
//
//  Created by Jui Joshi on 4/24/16.
//  Copyright (c) 2016 Jui Joshi. All rights reserved.
//

import UIKit
import MobileCoreServices


class ActionViewController: UIViewController {

//    @IBOutlet weak var imageView: UIImageView!

    @IBOutlet weak var extensionTextView: UITextView!
    
    override func viewDidLoad() {
        super.viewDidLoad()
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
    
        // Get the item[s] we're handling from the extension context.
        
//        // For example, look for an image and place it into an image view.
//        // Replace this with something appropriate for the type[s] your extension supports.
//        var imageFound = false
//        for item: AnyObject in self.extensionContext!.inputItems {
//            let inputItem = item as! NSExtensionItem
//            for provider: AnyObject in inputItem.attachments! {
//                let itemProvider = provider as NSItemProvider
//                if itemProvider.hasItemConformingToTypeIdentifier(kUTTypeImage as NSString) {
//                    // This is an image. We'll load it, then place it in our image view.
//                    weak var weakImageView = self.imageView
//                    itemProvider.loadItemForTypeIdentifier(kUTTypeImage as NSString, options: nil, completionHandler: { (image, error) in
//                        if image != nil {
//                            NSOperationQueue.mainQueue().addOperationWithBlock {
//                                if let imageView = weakImageView {
//                                    imageView.image = image as? UIImage
//                                }
//                            }
//                        }
//                    })
//                    
//                    imageFound = true
//                    break
//                }
//            }
//            
//            if (imageFound) {
//                // We only handle one image, so stop looking for more.
//                break
//            }
//        }
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }

    @IBAction func done() {
        // Return any edited content to the host app.
        // This template doesn't do anything, so we just echo the passed in items.
        
        let task = getData()
        print(task.assignee, terminator: "")
        
        self.extensionContext!.completeRequestReturningItems(self.extensionContext!.inputItems, completionHandler: nil)
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
