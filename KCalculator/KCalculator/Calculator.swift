//
//  Calculator.swift
//  KCalculator
//
//  Created by Ankit Grover on 4/25/16.
//  Copyright © 2016 Kohls. All rights reserved.
//

import Foundation

class Calculator {
    
    var total : Double
    var taxPct : Double
    var subtotal : Double {
        get {
            return total / (taxPct + 1)
        }
    }
    
    init(total: Double, taxPct: Double) {
        self.total = total;
        self.taxPct = taxPct;
    }
    
    func calcTipWithTipPct(tipPct : Double) ->Double {
        return subtotal * tipPct
    }
    
    func printPossibleTips() {
        print("%15 \(calcTipWithTipPct(0.15))")
    }
    
    func returnPossibleTips() -> [Int : Double] {
        let possibleTipsInferred = [0.15, 0.25, 0.50]
        var retVal = [Int: Double]()
        for possibleTip in possibleTipsInferred {
            let intPct: Int = Int(possibleTip * 100)
            retVal[intPct] = calcTipWithTipPct(possibleTip)
        }
        return retVal
    }
    
    
}
