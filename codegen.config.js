module.exports = {
  dependencies: {
    // If this is your app and not a library, you can leave this empty or skip it
  },
  project: {
    ios: {
      sourceDir: './ios',
    },
  },
  codegen: {
    // 👇 This is correct structure
    modules: [
      {
        type: 'modules',
        name: 'LoginModule',           // 👈 Must match the Swift class + moduleName()
        jsSrcsDir: './NativeModules',  // 👈 Folder where NativeLoginModuleSpec.ts is
      },
    ],
  },
};
