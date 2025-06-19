//
//  LoginModule.swift
//  NativeLogin
//
//  Created by aadi Katiyaan on 19/06/25.
//

import Foundation

import UIKit
import React
@objc(LoginModule)
class LoginModule : NSObject{
   @objc func ShowLogin(){
        DispatchQueue.main.async{
            if let rootView = UIApplication.shared.keyWindow?.rootViewController {
                let viewController = LoginViewController()
                rootView.present(viewController,animated:true,completion:nil)
            }
        }
   }

    @objc static func requiresMainQueueSetup()->Bool{
     return true 
   }

}
