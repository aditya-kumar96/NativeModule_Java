import { TurboModule, TurboModuleRegistry } from 'react-native';

export interface Spec extends TurboModule {
  showLogin(): void;
  logincallback(username: string): Promise<string>;
}

export default TurboModuleRegistry.getEnforcing<Spec>('LoginModule');
