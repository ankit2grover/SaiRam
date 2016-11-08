//
//  ResourceTableCellTableViewCell.swift
//  KScheduler
//
//  Created by Ankit Grover on 5/3/16.
//  Copyright © 2016 Kohls. All rights reserved.
//

import UIKit

class ResourceTableCellTableViewCell: UITableViewCell {

    
    @IBOutlet weak var nameLabel: UILabel!
    
    @IBOutlet weak var statusLabel: UILabel!
    
    @IBOutlet weak var taskLabel: UILabel!
    
    override func awakeFromNib() {
        super.awakeFromNib()
        // Initialization code
    }

    override func setSelected(selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)

        // Configure the view for the selected state
    }

}
