from locust import HttpUser, task
import time
class User(HttpUser):
    @task
    def get_employees(self) -> None:
        """Get a list of employees."""
        self.client.get("/", headers={"test-app": "1"})
        time.sleep(1)  # 1秒待機
