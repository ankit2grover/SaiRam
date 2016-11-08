//
//  ViewController.swift
//  Calendar
//
//

import UIKit

class ViewController: UIViewController {

   @IBOutlet var dateButtons: [UIButton]!
    
    var monthTasks = [MonthTasksData]()
    
    var displayCalendarDate : NSDate!
    
    var selectedDate = String()
    
    
  override func viewDidLoad() {
    super.viewDidLoad()
    loadCurrentMonthInCalendar()
  }
    
    @IBAction func loadNextMonth(sender: AnyObject) {

        // day of the week for the first of the current month
        let components = NSCalendar.currentCalendar().components([.Month, .Year] , fromDate: displayCalendarDate)
        displayCalendarBasedOnMonth((components.month + 1) % 12, year : components.year)
    }
    
    func displayCalendarBasedOnMonth(month : Int, year : Int) {
        
        let dateComponents = NSDateComponents()
        dateComponents.month = month
        dateComponents.year = year
        dateComponents.day = 1
        
        let date = NSCalendar(identifier: NSCalendarIdentifierGregorian)?.dateFromComponents(dateComponents)
        displayCalendarDate = date
        // month
        let month = getMonth(date!)
        self.title = month
        // last day of month
        let lastDay = getLastDayOfMonth(date!)
        
        displayCurrentMonthInCalendar(getWeekdayFor1stOfMonth(displayCalendarDate), month: month, lastDay: lastDay)

    }
    
    @IBAction func loadPrevMonth(sender: AnyObject) {
        // day of the week for the first of the current month
        let components = NSCalendar.currentCalendar().components([.Month, .Year] , fromDate: displayCalendarDate)
        displayCalendarBasedOnMonth((components.month - 1) % 12, year : components.year)
    }

    
    func loadCurrentMonthInCalendar() {
        // get today
        displayCalendarDate = getToday()
        
        // day of the week for the first of the current month
        let weekdayFor1stOfMonth = getWeekdayFor1stOfMonth(displayCalendarDate)
        // month
        let month = getMonth(displayCalendarDate)
        self.title = month
        // last day of month
        let lastDay = getLastDayOfMonth(displayCalendarDate)

        displayCurrentMonthInCalendar(weekdayFor1stOfMonth, month: month, lastDay: lastDay)
   }
    
    func getToday() -> NSDate {
        //let dateFormatter = NSDateFormatter()
        //dateFormatter.dateFormat = "MM-dd-yyyy"
        //return dateFormatter.dateFromString("05-02-2016")!
        return NSDate()
    }
    
    func getLastDayOfMonth(inputDate: NSDate) -> Int {
        let comps2 = NSDateComponents()
        comps2.month = 1
        comps2.day = -getDate(inputDate)
        
        let gregorianCalendar = NSCalendar(calendarIdentifier: NSCalendarIdentifierGregorian)!
        let endOfMonth = gregorianCalendar.dateByAddingComponents(comps2, toDate: inputDate, options: [])!
        return getDate(endOfMonth)
    }
    
    func getDate(inputDate: NSDate) -> Int {
        let dateFormatter = NSDateFormatter()
        dateFormatter.dateFormat = "dd"
        return Int(dateFormatter.stringFromDate(inputDate))!
    }
    
    func getWeekdayFor1stOfMonth(inputDate: NSDate) -> Int {
        // Retrive month and year of input date
        let components = NSCalendar.currentCalendar().components([.Month, .Year] , fromDate: inputDate)
        
        // Prepare date for first of the month
        let dateComponents = NSDateComponents()
        dateComponents.month = components.month
        dateComponents.year = components.year
        dateComponents.day = 1
        
        // Get week day
        let gregorianCalendar = NSCalendar(calendarIdentifier: NSCalendarIdentifierGregorian)!
        let startDate = gregorianCalendar.dateFromComponents(dateComponents)!
        let weekday = gregorianCalendar.component(.Weekday, fromDate: startDate)
        
        return weekday - 1
    }
  
    func getMonth(inputDate: NSDate) -> String {
        let dateFormatter = NSDateFormatter()
        dateFormatter.dateFormat = "MMM"
        return dateFormatter.stringFromDate(inputDate)
    }
    
    func displayCurrentMonthInCalendar(firstDay: Int, month: String, lastDay: Int) {
       loadTasksFromFileForMonth(month)
        
        for index in 0...dateButtons.count - 1{
            dateButtons[index].setTitle("" , forState: .Normal)
        }
        
        var buttonIndex = firstDay
        for index in 1...lastDay {
            let xNSNumber = index as NSNumber
            dateButtons[buttonIndex].setTitle(xNSNumber.stringValue, forState: .Normal)
            //getTasksForDate(xNSNumber.stringValue)
            buttonIndex  = buttonIndex + 1
        }
        
    }
    
    private func getTasksForDate(date: String) -> [Tasks] {
        var datetasks = [Tasks]()
        
        for tasksForDate : MonthTasksData in monthTasks {
            
            if (tasksForDate.taskDate == date) {
                print (date + " " + tasksForDate.taskDate)
            datetasks = tasksForDate.monthTasks
            
            }
        
        }
        return datetasks
    }
    
    func loadTasksFromFileForMonth(month: String)  {
        
        if let path = NSBundle.mainBundle().pathForResource("temp", ofType: "json") {
            do {
                let jsonData = try NSData(contentsOfFile: path, options: NSDataReadingOptions.DataReadingMappedIfSafe)
                do {
                    let jsonResult: NSDictionary = try NSJSONSerialization.JSONObjectWithData(jsonData, options: NSJSONReadingOptions.MutableContainers) as! NSDictionary
                     var tasks = [Tasks]()
                    var dateTasks: MonthTasksData!
                    
                    var monthTasksDictionary  = jsonResult[month] as! [NSDictionary]
                    for date in 0...monthTasksDictionary.count - 1 {
                    for (key, value) in monthTasksDictionary[date] {
                        tasks = [Tasks]()
                        for taskIndex in 0...value.count - 1 {
                        let taskName = value[taskIndex]["taskName"] as! String
                        let scheduled = (value[taskIndex]["scheduled"] as! NSString).boolValue
                        let estimatedHours = (value[taskIndex]["estimatedHours"] as! NSString).doubleValue
                        let endDate = value[taskIndex]["endDate"] as! String
                        let description = value[taskIndex]["description"] as! String
                        
                        let task = Tasks(taskName: taskName, scheduled: scheduled, estimatedHours: estimatedHours, endDate: endDate, description: description)
                       
                        tasks.append(task)
                        
                        dateTasks = MonthTasksData(taskDate: key as! String, monthTasks: tasks)
                            
                        }
                        
                        monthTasks.append(dateTasks)
                        
                    }
                    }
                    
                } catch {}
            } catch {}
        }
       // return monthTasks
    }

  override func didReceiveMemoryWarning() {
    super.didReceiveMemoryWarning()
    // Dispose of any resources that can be recreated.
  }
    
    override func prepareForSegue(segue: UIStoryboardSegue!, sender: AnyObject!) {
        if (segue.identifier == "GoToDetail") {
            let yourNextViewController = (segue.destinationViewController as! DetailsViewController)
            yourNextViewController.dateTasks = getTasksForDate(selectedDate)
        }
    }
    
    @IBAction func onDateSelected(sender: UIButton) {
        selectedDate = sender.currentTitle!
        print(selectedDate)
        self.performSegueWithIdentifier("GoToDetail", sender:self)
        
        
        
    }

}

