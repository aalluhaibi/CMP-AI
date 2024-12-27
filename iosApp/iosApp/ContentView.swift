import UIKit
import SwiftUI

struct ComposeView: UIViewControllerRepresentable {
    func makeUIViewController(context: Self.Context) -> UIViewController {
        MainViewControllerKt.MainViewController(generativeModel: GenerativeModelIOS.shared)
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Self.Context) {}
}

struct ContentView: View {
    var body: some View {
        ComposeView()
                .ignoresSafeArea(.keyboard)
                .ignoresSafeArea(.container) // Compose has own keyboard handler
    }
}



