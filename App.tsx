import React from 'react';
import {
  Alert,
  NativeModules,
  StyleSheet,
  Text,
  TouchableOpacity,
  useColorScheme,
  View,
} from 'react-native';

import LoginModule from './NativeModules/LoginModule.spec';

function App() {
  const isDarkMode = useColorScheme() === 'dark';

  const showNativeLogin = () => {
    LoginModule.showLogin(); // you can also pass initial values here if needed
    
  };

  return (
    <View
      style={[
        styles.container,
        { backgroundColor: isDarkMode ? '#111' : '#fff' },
      ]}>
      <TouchableOpacity style={styles.button} onPress={showNativeLogin}>
        <Text style={styles.buttonText}>Login Landing Page</Text>
      </TouchableOpacity>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
  },
  button: {
    width: 200,
    height: 60,
    backgroundColor: '#2196F3',
    borderRadius: 12,
    justifyContent: 'center',
    alignItems: 'center',
    elevation: 4,
  },
  buttonText: {
    color: '#fff',
    fontSize: 16,
    fontWeight: '600',
  },
});

export default App;
