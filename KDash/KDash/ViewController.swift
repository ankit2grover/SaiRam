//
//  ViewController.swift
//  KDash
//
//  Created by Ankit Grover on 4/25/16.
//  Copyright © 2016 Kohls. All rights reserved.
//

import UIKit

class ViewController: UIViewController, UITextFieldDelegate {

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
        self.navigationController!.navigationBar.hidden = true
        signTextField.delegate = self
        passwordTextField.delegate = self
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    


    // MARK: Properties
    
    @IBOutlet weak var signTextField: UITextField!

    @IBOutlet weak var passwordTextField: UITextField!
    
    func textFieldShouldReturn(textField: UITextField) -> Bool {
//        if (textField == signTextField) {
//            passwordTextField.nextResponder()
//        } else {
//            passwordTextField.resignFirstResponder()
//            
//        }
//        return true
        self.view.endEditing(true)
        return false
    }
    
    override func touchesBegan(touches: Set<UITouch>, withEvent event: UIEvent?) {
        self.view.endEditing(true)
    }
    
    
    // Mark : Actions
    
    @IBAction func signIn(sender: UIButton) {
        if (signTextField.text! == "" && passwordTextField.text! == "") {
            //signTextField.text! = "ankit"
//            let storyBoard = UIStoryboard(name:"Main", bundle: nil)
//            var tasksViewController: UIViewController = storyBoard.instantiateViewControllerWithIdentifier("tasks") as UIViewController
//            self.presentViewController(tasksViewController, animated: false, completion: nil)
            self.performSegueWithIdentifier("schedule", sender: nil)
            
        }
    }

}

