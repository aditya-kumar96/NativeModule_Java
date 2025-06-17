
import { NewAppScreen } from '@react-native/new-app-screen';
import { TouchableOpacity ,StatusBar, StyleSheet, Text, useColorScheme, View, NativeModules } from 'react-native';


function App() {
  const isDarkMode = useColorScheme() === 'dark';
  const {LoginModule} = NativeModules
  return (
    <View style={styles.container}>
      <TouchableOpacity style={{
        justifyContent:'center',
        alignItems:'center',
        width:150,
        height:100
      }}
      onPress={()=>{
        LoginModule.showLoginScreen()
      }}
      >
       <Text>Login Landing Page</Text> 
      </TouchableOpacity>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
  },
});

export default App;
