import React, {
  AppRegistry,
  Component,
  StyleSheet,
  Text,
  View
} from 'react-native';

var PickerIOSExample = require('./PickerIOSExample');

class ReactNativeExample extends Component {
  render() {
    return (
      <View>
        <PickerIOSExample />
      </View>
    );
  }
}

AppRegistry.registerComponent('ReactNativeExample', () => ReactNativeExample);