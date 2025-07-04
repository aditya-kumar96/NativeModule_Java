import Foundation
import React

@objc(LoginModule)
class LoginModule: NSObject {
  @objc func showLogin() {
    print("✅ ShowLogin called")
  }

  @objc func logincallback(
    _ username: String,
    resolver: @escaping RCTPromiseResolveBlock,
    rejecter: @escaping RCTPromiseRejectBlock
  ) {
    print("Login for \(username)")
    resolver("Welcome, \(username)")
  }
}

@objc(LoginModuleSpec)
protocol LoginModuleSpec: RCTBridgeModule {
  func showLogin()
  func logincallback(_ username: String, resolver: @escaping RCTPromiseResolveBlock, rejecter: @escaping RCTPromiseRejectBlock)
}

extension LoginModule: LoginModuleSpec {}
extension LoginModule: RCTTurboModule {}

extension LoginModule: RCTBridgeModule {
  static func moduleName() -> String! {
    return "LoginModule"
  }

  static func requiresMainQueueSetup() -> Bool {
    return false
  }
}
