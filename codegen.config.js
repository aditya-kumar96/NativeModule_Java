module.exports = {
    modules: [
      {
        type: 'modules',
        name: 'LoginModule',           // 👈 Must match class name
        jsSrcsDir: './NativeModules',  // 👈 Your .ts spec folder
      },
    ],
  };
  